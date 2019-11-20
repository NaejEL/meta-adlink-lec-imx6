# Copyright (C) 2013-2015 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel provided and supported by Freescale"
DESCRIPTION = "Linux Kernel provided and supported by Freescale with focus on \
i.MX Family Reference Boards. It includes support for many IPs such as GPU, VPU and IPU."

require recipes-kernel/linux/linux-imx.inc

DEPENDS += "lzop-native bc-native"

FILESPATH =. "${THISDIR}/${PN}_${PV}:${FILE_DIRNAME}/kexec-tools-${PV}:"

SRCBRANCH = "imx_4.1.15_1.0.0_ga"
KERNEL_SRC = "git://git.freescale.com/imx/linux-2.6-imx.git;protocol=git"

LOCALVERSION = "-1.2.0"
SRCREV = "77f61547834c4f127b44b13e43c59133a35880dc"
DEFAULT_PREFERENCE = "1"


COMPATIBLE_MACHINE = "(mx6|mx6ul|mx7)"

SRC_URI = " \
           ${KERNEL_SRC};branch=${SRCBRANCH} \
           file://defconfig \
           file://patch-4.1.15-16.patch \
           file://patch-4.1.16-17.patch \
           file://patch-4.1.17-18.patch \
           file://patch-4.1.18-19.patch \
           file://patch-4.1.19-20.patch \
           file://patch-4.1.20-21.patch \
           file://patch-4.1.21-22.patch \
           file://patch-4.1.22-23.patch \
           file://patch-4.1.23-24.patch \
           file://patch-4.1.24-25.patch \
           file://patch-4.1.25-26.patch \
           file://patch-4.1.26-27.patch \
           file://patch-4.1.27-28.patch \
           file://patch-4.1.28-29.patch \
           file://patch-4.1.29-30.patch \
           file://patch-4.1.30-31.patch \
           file://0002-pci-imx6-always-enable-pcie_bus-clock.patch \
           file://0003-pci-imx6-add-gen-2-timeout-message.patch \
           file://0004-pci-imx6.c-fix-BUG-scheduling-while-atomic.patch \
           file://0005-pci-imx6.c-add-config-option-to-force-GEN1-speed.patch \
           file://0006-Increase-several-PCIe-link-up-timeouts-for-PEX8605-s.patch \
           file://0007-Fix-PCIe-not-waking-up-properly-from-suspend.patch \
           file://0008-Fix-PCIe-root-port-losing-config-with-some-devices.patch \
           file://0009-imx6-optimize-compile-when-6Q-SL-SX-UL-7D-support-is.patch \
           file://0010-Restore-vanished-HDMI-DT-documentation.patch \
           file://0011-Clarify-kernel-message-indicating-the-CPU-variant.patch \
           file://0012-Improve-SD-MMC-power-consumption-and-speed.patch \
           file://0013-Add-user-kernel-split-Kconfig-options-for-full-1-or-.patch \
           file://0014-Implement-phase-shifted-SPI-clock-during-data-input.patch \
           file://0015-Misc-SPI-flash-device-table-fixes.patch \
           file://0016-Add-SST-26VF064B-SPI-flash-support.patch \
           file://0017-Fix-stall-during-mxc_hdmi_read_edid.patch \
           file://0018-Fix-camera-overlay-window-blocking-after-moving-resi.patch \
           file://0019-Fix-heavy-flickering-when-moving-camera-window.patch \
           file://0020-It-s-not-an-error-when-camera-power-isn-t-software-c.patch \
           file://0021-Work-around-OV564x-cameras-blocking-I2C-bus.patch \
           file://0022-Try-to-fix-panic-when-sound-driver-is-shut-down.patch \
           file://0023-Fix-and-streamline-TLV320AIC23-drivers.patch \
           file://0024-Fix-suspend-to-RAM-issues.patch \
           file://0026-Fork-imx6q-dl-sabresd-to-create-lec-imx6q-s.patch \
           file://0027-After-fork-change-copyright-references-names.patch \
           file://0028-Set-up-defaults-for-cross-compiling-for-ARM.patch \
           file://0029-On-HDMI-cable-insert-wait-for-things-to-settle.patch \
           file://0030-Revert-ENGR00299600-hdmi-yocto-gui-can-not-show-to-s.patch \
           file://0031-Create-DT-option-to-make-HDMI-accept-non-CEA-modes-f.patch \
           file://0032-Improve-parallel-RGB-signal-quality.patch \
           file://0033-Raise-default-thermal-trip-point-0-to-throttle-only-.patch \
           file://0034-Adapt-our-defconfig.patch \
           file://0035-Add-drivers-specific-to-LEC-Base-carriers-to-defconf.patch \
           file://0036-Drop-EPDC-incl.-pinmux-and-regulator-from-Solo.patch \
           file://0037-Most-GPIOs-differ-clear-hog-misc.-pinmux-device.patch \
           file://0038-Different-battery-charger-on-the-LEC-Base-R1-carrier.patch \
           file://0039-Add-instructive-comments.patch \
           file://0040-Our-SD-MMC-interfaces-are-used-differently.patch \
           file://0041-Our-SPI-is-connected-differently.patch \
           file://0042-Different-button-functions-on-GPIOs.patch \
           file://0043-Ethernet-is-subtly-different.patch \
           file://0044-More-UARTs-and-connected-differently.patch \
           file://0045-A-USB-hub-and-shared-power-enable-over-current-compl.patch \
           file://0046-Our-PWM-backlight-has-an-enable-pin-but-no-CABC.patch \
           file://0047-Our-I2C-buses-are-connected-differently.patch \
           file://0048-Drop-I2C-devices-our-boards-don-t-implement.patch \
           file://0049-Implement-NXP-PCA9535-IRQ-capable-I2C-GPIO-expander.patch \
           file://0050-Add-simple-on-module-I2C-devices.patch \
           file://0051-PCIe-uses-a-switch-and-other-minor-changes.patch \
           file://0052-We-can-t-use-the-MIPI-DSI-display-interface.patch \
           file://0053-Implement-SGTL5000-I2S-audio-on-the-LEC-Base-R2.patch \
           file://0054-We-have-either-SPI0-or-I2S0-depending-on-mux.patch \
           file://0055-Also-implement-TLV320AIC23-I2S-audio-on-the-LEC-Base.patch \
           file://0056-Set-up-S-PDIF-in-out-ports.patch \
           file://0057-A-PCF8575-controls-misc-signals-of-the-LEC-Base-R1-c.patch \
           file://0058-Adapt-camera-interfaces.patch \
           file://0059-Adapt-LVDS-and-parallel-RGB-panel-interfaces.patch \
           file://0060-Change-LVDS-output-to-24-bit-mode.patch \
           file://0061-Adapt-HDMI-interface.patch \
           file://0062-Add-DT-node-for-Media-Local-Bus-MLB.patch \
           file://0063-Enable-CAN-interfaces.patch \
           file://0064-Provide-a-way-to-configure-LDO-bypass.patch \
           file://0065-Add-option-to-activate-alternative-coda-VPU-driver.patch \
           file://0066-We-don-t-need-stdout-path-in-chosen-node.patch \
           file://0067-Some-Freescale-PFUZE100-PMIC-outputs-are-used-differ.patch \
           file://0068-Add-misc-I2C-and-SPI-devices-specific-to-the-LEC-Bas.patch \
           file://0069-SATA-signal-parameters-can-be-tuned.patch \
           "
