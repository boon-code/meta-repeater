DESCRIPTION = "Automatically set package version from Git."
HOMEPAGE = "https://github.com/pyfidelity/setuptools-git-version"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://setup.py;beginline=15;endline=15;md5=ba5f17915133a3b6556acac9dbcefe53"

inherit setuptools3 gitpkgv

SRC_URI = "git://github.com/pyfidelity/setuptools-git-version.git;protocol=https"

SRCREV = "7dd3929dfb950b2394bc952e2a87b51b70bd77bd"
PV = "1.0+gitr${SRCPV}"
PKGV = "${GITPKGVTAG}"

S = "${WORKDIR}/git"

BBCLASSEXTEND = "native nativesdk"
