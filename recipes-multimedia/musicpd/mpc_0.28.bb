DESCRIPTION = "A minimalist command line interface to MPD."
HOMEPAGE = "https://www.musicpd.org/clients/mpc/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS = "libmpdclient"
RDEPENDS_${PN} = "libmpdclient"

inherit autotools pkgconfig

SRC_URI = "https://www.musicpd.org/download/mpc/0/${PN}-${PV}.tar.xz"

SRC_URI[md5sum] = "e9cfaf17ab1db54dba4df4b08aa0db3f"
SRC_URI[sha256sum] = "a4337d06c85dc81a638821d30fce8a137a58d13d510be34a11c1cce95cabc547"
