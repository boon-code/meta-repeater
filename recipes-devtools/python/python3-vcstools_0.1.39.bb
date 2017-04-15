DESCRIPTION = "VCS/SCM source control library for svn, git, hg, and bzr"
HOMEPAGE = "http://wiki.ros.org/vcstools"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://setup.py;md5=6832becb2170a87c2fa0ae4b7dcff303"

inherit pypi setuptools3

SRC_URI[md5sum] = "c20e19e5a5b83520329bd2040bccb375"
SRC_URI[sha256sum] = "841bdfeca326b532ced45feea2a79b48008415ef117df008071ba74e985f59c1"

RDEPENDS_${PN} += " \
    ${PYTHON_PN}-pyyaml \
    ${PYTHON_PN}-dateutil \
"
