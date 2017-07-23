DESCRIPTION = "Configuration for connman"
SECTION = "services/setup"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

require conf/local-data.inc

RDEPENDS_${PN} = "connman"

SRC_URI = "${LOCALURI}/connman-config.tar.gz"

S = "${WORKDIR}/connman-config"

CM_CFGDIR = "${localstatedir}/lib/connman"

do_install() {
    install -d -m 0755 ${D}${CM_CFGDIR}
    
    for i in $(ls -d ${S}/wifi*/); do
        dir="$(basename "$i")"
        install -d -m 0700 ${D}${CM_CFGDIR}/$dir
        install -m 0600 ${S}/$dir/* ${D}${CM_CFGDIR}/$dir/
    done

    install -m 0600 ${S}/settings ${D}${CM_CFGDIR}/
}
