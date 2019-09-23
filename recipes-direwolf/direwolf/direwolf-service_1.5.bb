SUMMARY = "systemd service for Direwolf (Soundcard based AX.25 TNC)"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "file://direwolf.service \
           file://LICENSE"

SYSTEMD_SERVICE_${PN} = "direwolf.service"
SYSTEMD_AUTO_ENABLE_${PN} = "enable"

inherit systemd

do_install () {
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/direwolf.service ${D}${systemd_unitdir}/system
}

FILES_${PN} += "/lib/systemd/system"

REQUIRED_DISTRO_FEATURES= "systemd"
