# Copyright (C) 2017 Manuel Huber <Manuel.h87@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "A stable, documented, asynchronous API library for interfacing MPD in the C, C++ & Objective C languages."
HOMEPAGE = "https://www.musicpd.org/libs/libmpdclient/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=06b9dfd2f197dc514d8ef06549684b77"

inherit meson

SRC_URI = "https://www.musicpd.org/download/libmpdclient/2/${PN}-${PV}.tar.xz"

SRC_URI[md5sum] = "9c501be4ded3302b8d35ec8fa46ddbfc"
SRC_URI[sha256sum] = "9ecd1ed8f6e355c622ab10af4aef5fb06da21d2ffc5b6313747d0245ad8279f8"

FILES_${PN}-dev += "${datadir}/vala"
