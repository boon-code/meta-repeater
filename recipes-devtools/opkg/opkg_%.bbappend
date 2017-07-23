FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PKGURL ?= "http://192.168.0.178:8000"

SRC_URI += "file://opkg-local.conf"

do_install_append() {
    install ${WORKDIR}/opkg-local.conf ${D}${sysconfdir}/opkg/opkg.conf
    sed -i -e 's,@PKGURL@,${PKGURL},g' ${D}${sysconfdir}/opkg/opkg.conf
}
