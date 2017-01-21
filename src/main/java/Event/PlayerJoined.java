// automatically generated by the FlatBuffers compiler, do not modify

package Event;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class PlayerJoined extends Table {
  public static PlayerJoined getRootAsPlayerJoined(ByteBuffer _bb) { return getRootAsPlayerJoined(_bb, new PlayerJoined()); }
  public static PlayerJoined getRootAsPlayerJoined(ByteBuffer _bb, PlayerJoined obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public static boolean PlayerJoinedBufferHasIdentifier(ByteBuffer _bb) { return __has_identifier(_bb, "PLJN"); }
  public void __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; }
  public PlayerJoined __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public String id() { int o = __offset(4); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer idAsByteBuffer() { return __vector_as_bytebuffer(4, 1); }
  public long time() { int o = __offset(6); return o != 0 ? (long)bb.getInt(o + bb_pos) & 0xFFFFFFFFL : 0L; }
  public boolean mutateTime(long time) { int o = __offset(6); if (o != 0) { bb.putInt(o + bb_pos, (int)time); return true; } else { return false; } }
  public String name() { int o = __offset(8); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer nameAsByteBuffer() { return __vector_as_bytebuffer(8, 1); }
  public float x() { int o = __offset(10); return o != 0 ? bb.getFloat(o + bb_pos) : 0.0f; }
  public boolean mutateX(float x) { int o = __offset(10); if (o != 0) { bb.putFloat(o + bb_pos, x); return true; } else { return false; } }
  public float y() { int o = __offset(12); return o != 0 ? bb.getFloat(o + bb_pos) : 0.0f; }
  public boolean mutateY(float y) { int o = __offset(12); if (o != 0) { bb.putFloat(o + bb_pos, y); return true; } else { return false; } }
  public float rotation() { int o = __offset(14); return o != 0 ? bb.getFloat(o + bb_pos) : 0.0f; }
  public boolean mutateRotation(float rotation) { int o = __offset(14); if (o != 0) { bb.putFloat(o + bb_pos, rotation); return true; } else { return false; } }

  public static int createPlayerJoined(FlatBufferBuilder builder,
      int idOffset,
      long time,
      int nameOffset,
      float x,
      float y,
      float rotation) {
    builder.startObject(6);
    PlayerJoined.addRotation(builder, rotation);
    PlayerJoined.addY(builder, y);
    PlayerJoined.addX(builder, x);
    PlayerJoined.addName(builder, nameOffset);
    PlayerJoined.addTime(builder, time);
    PlayerJoined.addId(builder, idOffset);
    return PlayerJoined.endPlayerJoined(builder);
  }

  public static void startPlayerJoined(FlatBufferBuilder builder) { builder.startObject(6); }
  public static void addId(FlatBufferBuilder builder, int idOffset) { builder.addOffset(0, idOffset, 0); }
  public static void addTime(FlatBufferBuilder builder, long time) { builder.addInt(1, (int)time, (int)0L); }
  public static void addName(FlatBufferBuilder builder, int nameOffset) { builder.addOffset(2, nameOffset, 0); }
  public static void addX(FlatBufferBuilder builder, float x) { builder.addFloat(3, x, 0.0f); }
  public static void addY(FlatBufferBuilder builder, float y) { builder.addFloat(4, y, 0.0f); }
  public static void addRotation(FlatBufferBuilder builder, float rotation) { builder.addFloat(5, rotation, 0.0f); }
  public static int endPlayerJoined(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
  public static void finishPlayerJoinedBuffer(FlatBufferBuilder builder, int offset) { builder.finish(offset, "PLJN"); }
}

