package fr.kissy.zergling_push.model;

import Event.PlayerJoined;
import Event.PlayerMoved;
import Event.PlayerShot;
import com.google.flatbuffers.FlatBufferBuilder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.util.Date;
import java.util.List;

/**
 * Created by Guillaume on 19/01/2017.
 */
public class Player {
    private static final float _playerVelocityFactor = 0.8f;
    private static final float _playerAngularVelocityFactor = 0.006f;
    private static final float _playerDecelerationFactor = 0.05f;
    private static final float _moduloRadian = 2 * (float) Math.PI;
    private static final int MIN_X_Y_VALUE = 0;
    private static final int MAX_X_VALUE = 1920;
    private static final int MAX_Y_VALUE = 960;

    private String id;
    private String name;
    private float x;
    private float y;
    private float rotation;
    private byte velocity;
    private byte angularVelocity;
    private double residualVelocity;
    private List<Laser> lasers;

    public Player(PlayerJoined event, List<Laser> lasers) {
        this.id = event.id();
        this.name = event.name();
        this.x = event.x();
        this.y = event.y();
        this.lasers = lasers;
    }

    public void moved(PlayerMoved event) {
        if (this.velocity != event.velocity()) {
            this.residualVelocity = 1 - event.velocity();
        }

        this.x = event.x();
        this.y = event.y();
        this.rotation = event.rotation();
        this.velocity = event.velocity();
        this.angularVelocity = event.angularVelocity();
    }

    public void shot(PlayerShot event) {
        // Check validity ?
        this.lasers.add(new Laser(event.x(), event.y(), event.rotation()));
    }

    public void update(long deltaTime) {
        this.residualVelocity = Math.max(this.residualVelocity - _playerDecelerationFactor, 0);

        double currentVelocity = (this.velocity + this.residualVelocity) * _playerVelocityFactor * deltaTime;
        this.x = clamp((float) (this.x + currentVelocity * Math.sin(this.rotation)), MIN_X_Y_VALUE, MAX_X_VALUE);
        this.y = clamp((float) (this.y - currentVelocity * Math.cos(this.rotation)), MIN_X_Y_VALUE, MAX_Y_VALUE);
        this.rotation = (this.rotation + this.angularVelocity * _playerAngularVelocityFactor * deltaTime) % _moduloRadian;

        for (Laser laser : lasers) {
            laser.update(deltaTime);
        }
    }

    private float clamp(float value, float min, float max) {
        if (value < min) {
            return min;
        } else if (value > max) {
            return max;
        } else {
            return value;
        }
    }

    public ByteBuf createPlayerJoined() {
        FlatBufferBuilder fbb = new FlatBufferBuilder();
        int idOffset = fbb.createString(id);
        int nameOffset = fbb.createString(name);
        int offset = PlayerJoined.createPlayerJoined(fbb, idOffset, (int) new Date().getTime(), nameOffset, x, y, rotation);
        PlayerJoined.finishPlayerJoinedBuffer(fbb, offset);
        return Unpooled.wrappedBuffer(fbb.dataBuffer());
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}