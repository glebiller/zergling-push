// automatically generated by the FlatBuffers compiler, do not modify

/**
 * @const
 * @namespace
 */
var Event = Event || {};

/**
 * @constructor
 */
Event.TimeSyncRequest = function() {
  /**
   * @type {flatbuffers.ByteBuffer}
   */
  this.bb = null;

  /**
   * @type {number}
   */
  this.bb_pos = 0;
};

/**
 * @param {number} i
 * @param {flatbuffers.ByteBuffer} bb
 * @returns {Event.TimeSyncRequest}
 */
Event.TimeSyncRequest.prototype.__init = function(i, bb) {
  this.bb_pos = i;
  this.bb = bb;
  return this;
};

/**
 * @param {flatbuffers.ByteBuffer} bb
 * @param {Event.TimeSyncRequest=} obj
 * @returns {Event.TimeSyncRequest}
 */
Event.TimeSyncRequest.getRootAsTimeSyncRequest = function(bb, obj) {
  return (obj || new Event.TimeSyncRequest).__init(bb.readInt32(bb.position()) + bb.position(), bb);
};

/**
 * @param {flatbuffers.ByteBuffer} bb
 * @returns {boolean}
 */
Event.TimeSyncRequest.bufferHasIdentifier = function(bb) {
  return bb.__has_identifier('TSRQ');
};

/**
 * @returns {number}
 */
Event.TimeSyncRequest.prototype.time = function() {
  var offset = this.bb.__offset(this.bb_pos, 4);
  return offset ? this.bb.readUint32(this.bb_pos + offset) : 0;
};

/**
 * @param {flatbuffers.Builder} builder
 */
Event.TimeSyncRequest.startTimeSyncRequest = function(builder) {
  builder.startObject(1);
};

/**
 * @param {flatbuffers.Builder} builder
 * @param {number} time
 */
Event.TimeSyncRequest.addTime = function(builder, time) {
  builder.addFieldInt32(0, time, 0);
};

/**
 * @param {flatbuffers.Builder} builder
 * @returns {flatbuffers.Offset}
 */
Event.TimeSyncRequest.endTimeSyncRequest = function(builder) {
  var offset = builder.endObject();
  return offset;
};

/**
 * @param {flatbuffers.Builder} builder
 * @param {flatbuffers.Offset} offset
 */
Event.TimeSyncRequest.finishTimeSyncRequestBuffer = function(builder, offset) {
  builder.finish(offset, 'TSRQ');
};

// Exports for Node.js and RequireJS
this.Event = Event;
