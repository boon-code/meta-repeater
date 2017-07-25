DESCRIPTION = "Docker container to generate epub's from doc"
SECTION = "service/epub"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

require conf/local-data.inc
inherit systemd

RDEPENDS_${PN} = "curl"

SYSTEMD_SERVICE_${PN} = "epub-install.service epub-trigger.timer"

SRC_URI = " \
    file://epub-install.service \
    file://epub-install.sh \
    file://epub-trigger.timer \
    file://epub-trigger.service \
    file://epub-trigger.sh \
    ${LOCALURI}/epubd.tar.gz;unpack=0 \
"

EPUB_STATE_DIR = "${localstatedir}/lib/epub"

do_install() {
    install -d -m 0755 ${D}/opt
    install ${LOCAL_ABSPATH}/epubd.tar.gz ${D}/opt/

    install -d -m 0755 ${D}${systemd_system_unitdir}/
    install -d -m 0755 ${D}${EPUB_STATE_DIR}
    install -m 0644 ${WORKDIR}/epub-trigger.timer ${D}${systemd_system_unitdir}/
    install -m 0644 ${WORKDIR}/epub-trigger.service ${D}${systemd_system_unitdir}/
    install -m 0644 ${WORKDIR}/epub-install.service ${D}${systemd_system_unitdir}/
    install -d -m 0755 ${D}${sbindir}
    install -m 0755 ${WORKDIR}/epub-trigger.sh ${D}${sbindir}/
    install -m 0755 ${WORKDIR}/epub-install.sh ${D}${sbindir}/
    sed -i "s,/usr/sbin,${sbindir}," ${D}${systemd_system_unitdir}/epub-trigger.service \
                                     ${D}${systemd_system_unitdir}/epub-install.service
    sed -i "s,/var/lib/epub,${EPUB_STATE_DIR}," ${D}${systemd_system_unitdir}/epub-install.service \
                                                ${D}${sbindir}/epub-install.sh
}

FILES_${PN} += " \
    ${sbindir} \
    ${systemd_system_unitdir} \
    ${EPUB_STATE_DIR} \
    /opt \
"
