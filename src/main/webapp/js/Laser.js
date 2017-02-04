(function (window) {
    function Laser(x, y, rotation) {
        Phaser.Sprite.call(this, _game, x, y, 'laser');

        this.rotation = rotation;
        this.checkWorldBounds = true;
        this.outOfBoundsKill = true;

        this.anchor.set(0.5);

        _game.physics.enable(this, Phaser.Physics.ARCADE);
        _game.physics.arcade.velocityFromRotation(this.rotation - Math.PI / 2, _laserFullVelocity, this.body.velocity);


        _game.add.existing(this);
    }

    Laser.prototype = Object.create(Phaser.Sprite.prototype);
    Laser.prototype.constructor = Laser;

    Laser.prototype.update = function update() {
    };
    window.Laser = Laser;
})(window);