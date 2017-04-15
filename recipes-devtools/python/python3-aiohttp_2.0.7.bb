DESCRIPTION = "Async http client/server framework (asyncio)"
HOMEPAGE = "https://github.com/aio-libs/aiohttp/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=60dd5a575c9bd4339411bdef4a702d46"

inherit setuptools3 pypi

SRC_URI[md5sum] = "1ae6e69655389cbd0c81346492267314"
SRC_URI[sha256sum] = "76bfd47ee7fbda115cff486c3944fcb237ecbf6195bf2943fae74052fb40c4fe"

RDEPENDS_${PN} += " \
    ${PYTHON_PN}-chardet \
    ${PYTHON_PN}-multidict \
    ${PYTHON_PN}-async-timeout \
    ${PYTHON_PN}-yarl \
"
