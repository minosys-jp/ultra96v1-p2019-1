#!/bin/sh

### BEGIN INIT INFO
# Provides: Ultra96 wlan1 interface
# Required-Start:
# Required-Stop:
# Default-Start:S
# Default-Stop:
# Short-Description: attaches Ultra96 wlan1
# Description:       attaches Ultra96 wlan1
### END INIT INFO

DESC="ultra96-power-button.sh powers off the board when the power button is pushed"

case "\$1" in
  start)
    echo -n "Start Ultra96 wlan0"
    iw phy phy0 interface add wlan0 type managed
    echo "."
    ;;
  stop)
    echo -n "Stop Ultra96 wlan0"
    ifconfig wlan0 down
    ;;
  *)
    echo "Usage: /etc/init.d/ultra96-setup.sh {start|stop}"
    exit 1
esac

exit 0
