# Server-Client

Packet Filtering Firewall(server)

nano /etc/rc.conf

pf_enable="YES"
pf_rules="/etc/pf.conf"
pflog_enable="YES"
pflog_logfiles"/var/log/pflog"

CTRL X
Y
ENTER
exit

nano /etc/pf.conf

#chose either block or pass

int="wm0"
block log all
pass log all

ctrl x
Y
enter
exit

pfctl -e



