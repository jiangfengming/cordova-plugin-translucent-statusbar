var exec = require('cordova/exec');
var channel = require('cordova/channel');

var translucentStatusbar = {
  enabled: null,

  checkEnabled: function(onSuccess, onError) {
    if (cordova.platformId == 'android') {
      exec(onSuccess, onError, 'TranslucentStatusbar', 'checkEnabled', []);
    } else {
      onSuccess(true);
    }
  }
};

channel.onCordovaReady.subscribe(function() {
  translucentStatusbar.checkEnabled(function(enabled) {
    translucentStatusbar.enabled = enabled;
  });
});

module.exports = translucentStatusbar;
