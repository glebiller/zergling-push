// automatically generated by the FlatBuffers compiler, do not modify

package fr.kissy.zergling_push.event;

import java.nio.*;
import java.lang.*;

import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class PlayerConnect extends Table {
  public static PlayerConnect getRootAsPlayerConnect(ByteBuffer _bb) { return getRootAsPlayerConnect(_bb, new PlayerConnect()); }
  public static PlayerConnect getRootAsPlayerConnect(ByteBuffer _bb, PlayerConnect obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public static boolean PlayerConnectBufferHasIdentifier(ByteBuffer _bb) { return __has_identifier(_bb, "PLCO"); }
  public void __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; }
  public PlayerConnect __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }


  public static void startPlayerConnect(FlatBufferBuilder builder) { builder.startObject(0); }
  public static int endPlayerConnect(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
  public static void finishPlayerConnectBuffer(FlatBufferBuilder builder, int offset) { builder.finish(offset, "PLCO"); }
}
