SUMMARY = "Direwolf - native recipe"
DESCRIPTION = "Native recipe has been created only for fixing compile-time generation of fsk_fast_filter.h"
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

SRC_URI[md5sum] = "df444819172c01ab1d1d959e2b6f9a9e"
SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/wb2osz/direwolf.git;protocol=https;branch=master \
           file://0001-Change-makefile-for-native-recipe.patch \
           "

BBCLASSEXTEND = "native"
inherit native

S = "${WORKDIR}/git/"

do_compile () {
    oe_runmake fsk_fast_filter.h
}

do_install_class-native() {
    install -d ${D}${includedir}
    install -m 0644 ${S}/fsk_fast_filter.h ${D}${includedir}
}
