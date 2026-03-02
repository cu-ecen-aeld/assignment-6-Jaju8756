inherit module update-rc.d

# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f098732a73b5f6f3430472f5b094ffdb"

SRC_URI = "git://github.com/cu-ecen-aeld/assignment-7-Jaju8756.git;protocol=https;branch=main\ 
	   file://misc-modules-init \
	   "

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "d6d0c0785194a6c3a34d5141ddc2a3a431f1a911"

S = "${WORKDIR}/git"

INITSCRIPT_NAME = "misc-modules-init"
INITSCRIPT_PARAMS = "start 03 S ."

FILES:${PN} += "${sysconfdir}/init.d/misc-modules-init"

# IMPORTANT CHANGE HERE:
EXTRA_OEMAKE += "-C ${STAGING_KERNEL_DIR} M=${S}/misc-modules EXTRA_CFLAGS=-I${S}/include"

do_install:append() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/misc-modules-init ${D}${sysconfdir}/init.d/misc-modules-init
}

