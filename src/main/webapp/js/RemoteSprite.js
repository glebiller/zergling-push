(function (window) {
    function RemoteSprite(game, remoteWorld, event, texture) {
        Phaser.Sprite.call(this, game, event.x(), event.y(), texture);

        this.remoteWorld = remoteWorld;
        this.name = event.id();
        this.currentSnapshot = event;
        this.targetSnapshot = event;
    }

    RemoteSprite.prototype = Object.create(Phaser.Sprite.prototype);
    RemoteSprite.prototype.constructor = RemoteSprite;

    RemoteSprite.prototype.updateTargetSnapshot = function updateTargetSnapshot(playerSnapshot) {
        this.currentSnapshot = this.targetSnapshot;
        this.targetSnapshot = playerSnapshot;
    };

    RemoteSprite.prototype.update = function update(deltaTime) {
        // Network reconciliation
        var targetAngle = Phaser.Math.wrapAngle(this.targetSnapshot.rotation() - this.currentSnapshot.rotation(), true);
        this.rotation = this.currentSnapshot.rotation() + targetAngle * this.remoteWorld.getSnapshotCurrentTime();
        this.x = Phaser.Math.linear(this.currentSnapshot.x(), this.targetSnapshot.x(), this.remoteWorld.getSnapshotCurrentTime());
        this.y = Phaser.Math.linear(this.currentSnapshot.y(), this.targetSnapshot.y(), this.remoteWorld.getSnapshotCurrentTime());
    };

    RemoteSprite.prototype.debug = function debug() {
        // this.game.debug.geom(new Phaser.Rectangle(this.targetSnapshot.x() - (this.width / 2),
        //     this.targetSnapshot.y() - (this.height / 2), this.width, this.height), "green", false);
        // this.game.debug.geom(new Phaser.Rectangle(this.currentSnapshot.x() - (this.width / 2),
        //     this.currentSnapshot.y() - (this.height / 2), this.width, this.height), "red", false);
    };

    window.RemoteSprite = RemoteSprite;
})(window);