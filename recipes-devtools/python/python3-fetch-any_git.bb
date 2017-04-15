DESCRIPTION = "Fetch multiple repositories (git, svn, hg, bzr, tar)"
HOMEPAGE = "https://github.com/boon-code/fetch-any"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1a82f938aeb2c146896061d04aae9e5b"

DEPENDS += "${PYTHON_PN}-setuptools-git-version-native"

inherit setuptools3 gitpkgv

SRC_URI = "git://github.com/boon-code/fetch-any.git;protocol=https"

SRCREV = "${AUTOREV}"
PV = "1.0+gitr${SRCPV}"
PKGV = "${GITPKGVTAG}"

S = "${WORKDIR}/git"

RDEPENDS_${PN} += " \
    ${PYTHON_PN}-docopt \
    ${PYTHON_PN}-vcstools \
"
