# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
LICENSE = "LGPLv2.1 & Unknown & GPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=4fbd65380cdd255951079008b364516c \
                    file://LICENSE;md5=26a5cc8916f735c4f06dfdbb1989a0b0 \
                    file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "https://github.com/Hamlib/Hamlib/archive/Hamlib-${PV}.zip"
SRC_URI[md5sum] = "077b98d4446a1bc99bf7a997ed1c5d53"
SRC_URI[sha256sum] = "d250a1df86b48de4b7156f68efe8fd65eae9a878356e56b25c0c1b30f73b66cb"

S = "${WORKDIR}/Hamlib-Hamlib-${PV}"

# NOTE: unable to map the following pkg-config dependencies: usrp
#       (this is based on recipes that have previously been built and packaged)
# NOTE: the following library dependencies are unknown, ignoring: gd ws2_32
#       (this is based on recipes that have previously been built and packaged)
DEPENDS = "libusb1 swig-native libxml2 libnsl2"

# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
inherit pkgconfig pythonnative autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = ""

