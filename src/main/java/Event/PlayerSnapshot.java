// automatically generated by the FlatBuffers compiler, do not modify

package Event;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class PlayerSnapshot extends Table {
  public static PlayerSnapshot getRootAsPlayerSnapshot(ByteBuffer _bb) { return getRootAsPlayerSnapshot(_bb, new PlayerSnapshot()); }
  public static PlayerSnapshot getRootAsPlayerSnapshot(ByteBuffer _bb, PlayerSnapshot obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__init(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public static boolean PlayerSnapshotBufferHasIdentifier(ByteBuffer _bb) { return __has_identifier(_bb, "PLSP"); }
  public PlayerSnapshot __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; return this; }

  public String id() { int o = __offset(4); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer idAsByteBuffer() { return __vector_as_bytebuffer(4, 1); }
  public long sequence() { int o = __offset(6); return o != 0 ? (long)bb.getInt(o + bb_pos) & 0xFFFFFFFFL : 0; }
  public float x() { int o = __offset(8); return o != 0 ? bb.getFloat(o + bb_pos) : 0.0f; }
  public float y() { int o = __offset(10); return o != 0 ? bb.getFloat(o + bb_pos) : 0.0f; }
  public float rotation() { int o = __offset(12); return o != 0 ? bb.getFloat(o + bb_pos) : 0.0f; }
  public Event.PlayerShotSnapshot shots(int j) { return shots(new Event.PlayerShotSnapshot(), j); }
  public Event.PlayerShotSnapshot shots(Event.PlayerShotSnapshot obj, int j) { int o = __offset(14); return o != 0 ? obj.__init(__indirect(__vector(o) + j * 4), bb) : null; }
  public int shotsLength() { int o = __offset(14); return o != 0 ? __vector_len(o) : 0; }

  public static int createPlayerSnapshot(FlatBufferBuilder builder,
      int idOffset,
      long sequence,
      float x,
      float y,
      float rotation,
      int shotsOffset) {
    builder.startObject(6);
    PlayerSnapshot.addShots(builder, shotsOffset);
    PlayerSnapshot.addRotation(builder, rotation);
    PlayerSnapshot.addY(builder, y);
    PlayerSnapshot.addX(builder, x);
    PlayerSnapshot.addSequence(builder, sequence);
    PlayerSnapshot.addId(builder, idOffset);
    return PlayerSnapshot.endPlayerSnapshot(builder);
  }

  public static void startPlayerSnapshot(FlatBufferBuilder builder) { builder.startObject(6); }
  public static void addId(FlatBufferBuilder builder, int idOffset) { builder.addOffset(0, idOffset, 0); }
  public static void addSequence(FlatBufferBuilder builder, long sequence) { builder.addInt(1, (int)sequence, 0); }
  public static void addX(FlatBufferBuilder builder, float x) { builder.addFloat(2, x, 0.0f); }
  public static void addY(FlatBufferBuilder builder, float y) { builder.addFloat(3, y, 0.0f); }
  public static void addRotation(FlatBufferBuilder builder, float rotation) { builder.addFloat(4, rotation, 0.0f); }
  public static void addShots(FlatBufferBuilder builder, int shotsOffset) { builder.addOffset(5, shotsOffset, 0); }
  public static int createShotsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startShotsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static int endPlayerSnapshot(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
  public static void finishPlayerSnapshotBuffer(FlatBufferBuilder builder, int offset) { builder.finish(offset, "PLSP"); }
}

