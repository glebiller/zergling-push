// automatically generated by the FlatBuffers compiler, do not modify

package Event;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class PlayerShotSnapshot extends Table {
  public static PlayerShotSnapshot getRootAsPlayerShotSnapshot(ByteBuffer _bb) { return getRootAsPlayerShotSnapshot(_bb, new PlayerShotSnapshot()); }
  public static PlayerShotSnapshot getRootAsPlayerShotSnapshot(ByteBuffer _bb, PlayerShotSnapshot obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public static boolean PlayerShotSnapshotBufferHasIdentifier(ByteBuffer _bb) { return __has_identifier(_bb, "PSSP"); }
  public void __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; }
  public PlayerShotSnapshot __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public String id() { int o = __offset(4); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer idAsByteBuffer() { return __vector_as_bytebuffer(4, 1); }
  public float x() { int o = __offset(6); return o != 0 ? bb.getFloat(o + bb_pos) : 0.0f; }
  public boolean mutateX(float x) { int o = __offset(6); if (o != 0) { bb.putFloat(o + bb_pos, x); return true; } else { return false; } }
  public float y() { int o = __offset(8); return o != 0 ? bb.getFloat(o + bb_pos) : 0.0f; }
  public boolean mutateY(float y) { int o = __offset(8); if (o != 0) { bb.putFloat(o + bb_pos, y); return true; } else { return false; } }
  public float rotation() { int o = __offset(10); return o != 0 ? bb.getFloat(o + bb_pos) : 0.0f; }
  public boolean mutateRotation(float rotation) { int o = __offset(10); if (o != 0) { bb.putFloat(o + bb_pos, rotation); return true; } else { return false; } }

  public static int createPlayerShotSnapshot(FlatBufferBuilder builder,
      int idOffset,
      float x,
      float y,
      float rotation) {
    builder.startObject(4);
    PlayerShotSnapshot.addRotation(builder, rotation);
    PlayerShotSnapshot.addY(builder, y);
    PlayerShotSnapshot.addX(builder, x);
    PlayerShotSnapshot.addId(builder, idOffset);
    return PlayerShotSnapshot.endPlayerShotSnapshot(builder);
  }

  public static void startPlayerShotSnapshot(FlatBufferBuilder builder) { builder.startObject(4); }
  public static void addId(FlatBufferBuilder builder, int idOffset) { builder.addOffset(0, idOffset, 0); }
  public static void addX(FlatBufferBuilder builder, float x) { builder.addFloat(1, x, 0.0f); }
  public static void addY(FlatBufferBuilder builder, float y) { builder.addFloat(2, y, 0.0f); }
  public static void addRotation(FlatBufferBuilder builder, float rotation) { builder.addFloat(3, rotation, 0.0f); }
  public static int endPlayerShotSnapshot(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
  public static void finishPlayerShotSnapshotBuffer(FlatBufferBuilder builder, int offset) { builder.finish(offset, "PSSP"); }
}
