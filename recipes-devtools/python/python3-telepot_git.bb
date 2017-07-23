DESCRIPTION = "Python framework for Telegram Bot API"
HOMEPAGE = "https://github.com/nickoala/telepot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=9fd8eb0ab2532addaf4a245156b83f83"

inherit setuptools3 gitpkgv

SRC_URI = "git://github.com/nickoala/telepot.git;protocol=https"

SRCREV = "8da5bc53e0f46a0bb07e88e0d4cc6e8d703143dd"
PV = "12.1+gitr${SRCPV}"
PKGV = "${GITPKGVTAG}"

S = "${WORKDIR}/git"

RDEPENDS_${PN} += " \
    ${PYTHON_PN}-urllib3 \
    ${PYTHON_PN}-aiohttp \
"
