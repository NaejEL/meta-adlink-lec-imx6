# LEC SMARC distribution ADLINK layers

Layer to support the ADLINK SOM and the ADLINK LEC board.

## Machine imx6lec.conf

Based on the imx-base and tune-cortexa9 machine.
The linux-imx version is downgradded to 4.1.15. The version 4.1.15 is the one
used by the distribution given by adlink.

## Distribution fsl-adlink

Based on fslc-base.
Use wayland instead of X11

## Recipes

### Images

Update the fsl-image-multimedia to use sema (Smart Embedded Management Agent,
e.g. allows monitoring CPU and board temperature and other vital parameters)

### Graphiques

The distribution use wayland as graphical interface.
Weston-ini:
 - Add a way to configure the daemon (/etc/default/weston)

### Kernel

The linux-imx version in yocto rocko does not boot on the board. the faster way
was to get it from the adlink distribution.
Linux-imx 4.1.15 backported from the adlink distribution.

### Multimedia

Use imx-gst1.0 as gstreamer imx plugin. Change the version avaible in yocto rocko,
it does not compile with the backported kernel.
