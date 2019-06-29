#
# This is the peekpoke apllication recipe
#
#

SUMMARY = "iw: wireless utility"
SECTION = "PETALINUX/apps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " file://ap.c file://bitrate.c file://bloom.c file://coalesce.c file://connect.c file://cqm.c file://event.c file://ftm.c file://genl.c file://hwsim.c file://ibss.c file://info.c file://interface.c file://iw.c file://link.c file://measurements.c file://mesh.c file://mgmt.c file://mpath.c file://mpp.c file://nan.c file://ocb.c file://offch.c file://p2p.c file://phy.c file://ps.c file://reason.c file://reg.c file://roc.c file://scan.c file://sections.c file://sha256.c file://station.c file://status.c file://survey.c file://util.c file://vendor.c file://wowlan.c file://Makefile file://ieee80211.h file://iw.h file://nl80211.h file://sha256.h file://version.sh "

S = "${WORKDIR}"
DEPENDS = "libnl"
CFLAGS_prepend = "-DCONFIG_LIBNL30 -I ${S} -I ${STAGING_INCDIR}/libnl3"
export MYLIBDIR = "${STAGING_DIR}/usr/lib"
do_compile() {
        oe_runmake
}
do_install() {
        install -d ${D}${sbindir}
        install -m 0755 ${S}/iw ${D}${sbindir}
}

