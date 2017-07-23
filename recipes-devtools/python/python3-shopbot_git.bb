DESCRIPTION = "Telegram Bot that manages your shopping list"
HOMEPAGE = "https://github.com/boon-code/shoppingbot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=57982d1d6744c4a7d03a67e9f011bf13"

DEPENDS += " ${PYTHON_PN}-setuptools-git-version-native "

inherit setuptools3 gitpkgv

SRC_URI = "git://github.com/boon-code/shoppingbot.git;protocol=https;branch=master"

SRCREV = "${AUTOREV}"
PV = "1.0+gitr${SRCPV}"
PKGV = "${GITPKGVTAG}"

S = "${WORKDIR}/git"

RDEPENDS_${PN} += " \
    ${PYTHON_PN}-argparse \
    ${PYTHON_PN}-argcomplete \
    ${PYTHON_PN}-telepot \
    ${PYTHON_PN}-blessings \
    ${PYTHON_PN}-tinydb \
"
