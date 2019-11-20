# Add
#
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " file://0001-Prepend-PKG_CONFIG_SYSROOT_DIR-to-pkg-config-output.patch"

DEPENDS_append_mx7ulp = " libdrm"

PACKAGE_ARCH_imxpxp = "${MACHINE_SOCARCH}"
PACKAGE_ARCH_mx8 = "${MACHINE_SOCARCH}"

EXTRA_OECONF += "WAYLAND_PROTOCOLS_SYSROOT_DIR=${RECIPE_SYSROOT}"
