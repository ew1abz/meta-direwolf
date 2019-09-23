SUMMARY = "Soundcard based AX.25 TNC"
SECTION = "hamradio"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE-other.txt
#   regex/LICENSES
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
LICENSE = "Unknown & GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE-other.txt;md5=6647050027a94e202de73b14daa630d5 \
                    file://LICENSE-dire-wolf.txt;md5=fa22e16ebbe6638b2bd253338fbded9f \
                    file://regex/LICENSES;md5=07a394b26e0902b9ffdec03765209770 \
                    file://regex/COPYING;md5=393a5ca445f6965873eca0259a17f833"

SRC_URI = "git://github.com/wb2osz/direwolf.git;protocol=https \
           file://0001-Fix-cross-compilation.patch \
           "

DEPENDS = "alsa-lib hamlib gpsd direwolf-native"

PV = "1.5+git${SRCPV}"
SRCREV = "a1e2d1c3a88723e41efaf44a10f6374e6dfdd8df"

S = "${WORKDIR}/git"

do_configure () {
	cp ${STAGING_INCDIR_NATIVE}/fsk_fast_filter.h ${S}
}

do_compile () {
	oe_runmake INCLUDEDIR=${STAGING_INCDIR}
}

do_install () {
	oe_runmake install DESTDIR=${D} SBINDIR=${sbindir} INCLUDEDIR=${includedir} SYSCONFDIR=${D}${sysconfdir} DATADIR=${D}${datadir}
	install -d ${D}${sysconfdir}
	install -m 0644 ${S}/direwolf.conf ${D}${sysconfdir}
	install -m 0644 ${S}/sdr.conf ${D}${sysconfdir}
}
