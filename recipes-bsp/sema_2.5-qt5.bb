# Recipe provides 2 packages: 'sema' contains hardware libs incl. command line
# tool, and 'semagui', which depends on it and on Qt.
DESCRIPTION = "ADLINK SEMA (Smart Embedded Management Agent) e.g. allows monitoring CPU and board temperature and other vital parameters."
HOMEPAGE = "http://www.adlinktech.com/"
SECTION = "utils"

DESCRIPTION_semagui = "${DESCRIPTION}  This package contains the graphical front-end."
SUMMARY_semagui = "${SUMMARY} - Qt GUI"

LICENSE = "ADLINK_SEMA"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8bd2802ee4226887df6b0da9a9ca44e6"

SRC_URI = "file://sema-2.5-qt5_Yocto-bin.tar.xz"

do_compile() {
}
INSANE_SKIP_${PN} += "already-stripped"

do_install() {
	install -d ${D}${libdir} ${D}${bindir} ${D}${datadir}/applications
	install -m 644 ${B}/driver/linux/libsema_hwlinux.so* ${B}/libsema/lib*sema.so* ${D}${libdir}
	install ${B}/sema/sema ${B}/gui/semagui ${D}${bindir}
	cat >${D}${datadir}/applications/semagui.desktop <<-EOF
		[Desktop Entry]
		Encoding=UTF-8
		Type=Application
		Name=SEMA GUI
		Comment=ADLINK Smart Embedded Management Agent
		Exec=${bindir}/semagui
		Icon=preferences-desktop
		Terminal=false
		Categories=Application;
		X-MB-SingleInstance=true
		StartupNotify=false
	EOF
}

# Drop -dev, merge libs into main pkg, they're not much use alone and sema
# cmdline is just 30k. (FILES_${PN}-dev="" results in empty pkg which sema
# depends(!) on, and PACKAGES-="${PN}-dev" doesn't exist, so assign all.) And
# split off GUI because of it's Qt dependency. Keep -doc and -locale, maybe
# we'll use them some day.
PACKAGES = "${PN}-doc ${PN}-locale semagui ${PN}"
FILES_semagui = "${bindir}/semagui ${datadir}/applications/semagui.desktop"
FILES_${PN} += "${libdir}"
