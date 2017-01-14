(function (window) {
    var _handlers = {},
        // special keys
        _MAP = {
            backspace: 8, tab: 9, clear: 12,
            enter: 13, 'return': 13,
            esc: 27, escape: 27, space: 32,
            left: 37, up: 38,
            right: 39, down: 40,
            del: 46, 'delete': 46,
            home: 36, end: 35,
            pageup: 33, pagedown: 34,
            ',': 188, '.': 190, '/': 191,
            '`': 192, '-': 189, '=': 187,
            ';': 186, '\'': 222,
            '[': 219, ']': 221, '\\': 220
        },
        code = function (x) {
            return _MAP[x] || x.toUpperCase().charCodeAt(0);
        },
        _downKeys = [];

    for (var k = 1; k < 20; k++) {
        _MAP['f' + k] = 111 + k;
    }

    // IE doesn't support Array#indexOf, so have a simple replacement
    function index(array, item) {
        var i = array.length;
        while (i--) if (array[i] === item) return i;
        return -1;
    }

    function dispatch(event) {
        var key, handler;
        key = event.keyCode;

        var keyIndex = index(_downKeys, key);
        if (event.type == 'keydown') {
            if (keyIndex >= 0) {
                return;
            } else {
                _downKeys.push(key);
            }
        } else {
            if (keyIndex >= 0) {
                _downKeys.splice(keyIndex, 1);
            }
        }

        // right command on webkit, command on Gecko
        if (key == 93 || key == 224) {
            key = 91;
        }

        // abort if no potentially matching shortcuts found
        if (!(key in _handlers)) {
            return;
        }

        // for each potential shortcut
        for (var i = 0; i < _handlers[key].length; i++) {
            handler = _handlers[key][i];

            // call the handler and stop the event if neccessary
            var eventHandler = handler[event.type + 'Listener'];
            if (eventHandler && eventHandler.call(event, handler) === false) {
                if (event.preventDefault) {
                    event.preventDefault();
                } else {
                    event.returnValue = false;
                }
                if (event.stopPropagation) {
                    event.stopPropagation();
                }
                if (event.cancelBubble) {
                    event.cancelBubble = true;
                }
            }
        }
    }

    function getKeys(key) {
        var keys;
        key = key.replace(/\s/g, '');
        keys = key.split(',');
        if ((keys[keys.length - 1]) == '') {
            keys[keys.length - 2] += ',';
        }
        return keys;
    }

    function addEvent(object, event, callback) {
        if (object.addEventListener) {
            object.addEventListener(event, callback, false);
        } else if (object.attachEvent) {
            object.attachEvent('on' + event, function () {
                callback(window.event)
            });
        }
    }

    // set the handlers globally on document
    addEvent(document, 'keydown', function (event) {
        dispatch(event);
    });
    addEvent(document, 'keyup', function (event) {
        dispatch(event);
    });

    window.Keyboard = {
        bind: function bind(key, keydownListener, keyupListener) {
            var keys = getKeys(key);
            for (var i = 0; i < keys.length; i++) {
                key = code(key);
                // ...store handler
                if (!(key in _handlers)) {
                    _handlers[key] = [];
                }
                _handlers[key].push({key: keys[i], keydownListener: keydownListener, keyupListener: keyupListener});
            }
        },
        unbind: function unbind(key) {
            var multipleKeys = getKeys(key);
            for (var j = 0; j < multipleKeys.length; j++) {
                key = multipleKeys[j];
                key = code(key);

                if (!_handlers[key]) {
                    return;
                }
                for (var i = 0; i < _handlers[key].length; i++) {
                    _handlers[key][i] = {};
                }
            }
        },
        isKeyPressed: function isKeyPressed(keyCode) {
            if (typeof(keyCode) == 'string') {
                keyCode = code(keyCode);
            }
            return index(_downKeys, keyCode) != -1;
        },
        getPressedKeyCodes: function getPressedKeyCodes() {
            return _downKeys.slice(0);
        }
    };
})(window);