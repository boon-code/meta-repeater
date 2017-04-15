DESCRIPTION = "Python framework for Telegram Bot API"
HOMEPAGE = "https://github.com/nickoala/telepot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=9fd8eb0ab2532addaf4a245156b83f83"

inherit setuptools3 gitpkgv

SRC_URI = "git://github.com/nickoala/telepot.git;protocol=https"

SRCREV = "aad059b9c61b586132a92b637de3e5b72e28b18a"
PV = "1.0+gitr${SRCPV}"
PKGV = "${GITPKGVTAG}"

S = "${WORKDIR}/git"

RDEPENDS_${PN} += " \
    ${PYTHON_PN}-urllib3 \
    ${PYTHON_PN}-aiohttp \
"
