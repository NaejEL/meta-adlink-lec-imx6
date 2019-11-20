FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " file://default "

do_install_append() {
    install -d ${D}/${sysconfdir}/default
  	install -m 644 ${WORKDIR}/default ${D}${sysconfdir}/default/weston
}

FILES_${PN}_append = " ${sysconfdir}/default/weston "
