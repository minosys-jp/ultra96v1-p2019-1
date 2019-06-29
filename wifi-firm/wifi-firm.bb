#
# This is the peekpoke apllication recipe
#
#

SUMMARY = "wifi-firm: TI WiFi firmware"
SECTION = "PETALINUX/apps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " file://TIInit_11.8.32.bts file://wl18xx-fw.bin file://wl18xx-fw-2.bin file://wl18xx-fw-3.bin file://wl18xx-fw-4.bin file://ultra96-setup.sh"

S = "${WORKDIR}"
F = "${D}/lib/firmware"
C = "${F}/ti-connectivity"

DEPENDS = "libnl wpa-supplicant"

#CFLAGS_prepend = "-DCONFIG_LIBNL30 -I ${S} -I ${STAGING_INCDIR}/libnl3"
#export MYLIBDIR = "${STAGING_DIR}/usr/lib"
#do_compile() {
#        oe_runmake
#}
do_install() {
}

do_install_append () {
        mkdir -p ${C}
	cp -rfp ${S}/TIInit_11.8.32.bts ${C}
	cp -rfp ${S}/wl18xx-fw.bin ${C}
	cp -rfp ${S}/wl18xx-fw-2.bin ${C}
	cp -rfp ${S}/wl18xx-fw-3.bin ${C}
	cp -rfp ${S}/wl18xx-fw-4.bin ${C}
	cp -rfp ${S}/wl18xx-fw.bin ${C}
	mkdir -p ${D}/etc/init.d
	cp -rfp ${S}/ultra96-setup.sh ${D}${sysconfdir}/init.d
	chmod +x ${D}/etc/init.d/ultra96-setup.sh
	mkdir -p ${D}/etc/rcS.d
	pushd ${D}/etc/rcS.d
	rm -f S99ultra96-setup.sh
	ln -s ../init.d/ultra96-setup.sh S99ultra96-setup.sh
	popd
}

FILES_${PN} += "/etc/init.d /etc/rcS.d /lib /lib/firmware /lib/firmware/ti-connectivity /lib/firmware/ti-connectivity/TIInit_11.8.32.bts /lib/firmware/ti-connectivity/wl18xx-fw-2.bin /lib/firmware/ti-connectivity/wl18xx-fw.bin /lib/firmware/ti-connectivity/wl18xx-fw-4.bin /lib/firmware/ti-connectivity/wl18xx-fw-3.bin "
