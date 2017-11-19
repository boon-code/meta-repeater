DESCRIPTION = "IR receiver script for RPI"
HOMEPAGE = "https://github.com/boon-code/rpi-ir"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

require conf/local-data.inc
inherit systemd

RDEPENDS_${PN} = " \
    python3 \
    python3-terminal \
    python3-json \
    python3-requests \
    mpc \
    alsa-utils-amixer \
"

SYSTEMD_SERVICE_${PN} = "irpoll.service"

SRC_URI = " \
    git://github.com/boon-code/rpi-ir.git;protocol=https;branch=master \
    file://irpoll.service \
    file://90-irpoll-usb-device.rules \
    ${LOCALURI}/irpoll-config.json \
    ${LOCALURI}/irpoll-users.json \
"

SRCREV = "1b1453a1a0d3ae6ff0cd16f35fe272fbb01b00bb"

S = "${WORKDIR}/git"

IR_POLL_STATE_DIR = "${localstatedir}/lib/irpoll"

do_install() {
    install -d -m 0755 ${D}${sbindir}
    install -m 0755 ${S}/irpoll.py ${D}${sbindir}/
    install -d -m 0755 ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/irpoll.service ${D}${systemd_system_unitdir}/
    sed -i "s,/usr/sbin,${sbindir}," ${D}${systemd_system_unitdir}/irpoll.service
    sed -i "s,/var/lib/irpoll,${IR_POLL_STATE_DIR}," ${D}${systemd_system_unitdir}/irpoll.service

    install -d -m 0755 ${D}${IR_POLL_STATE_DIR}
    install -m 0644 ${LOCAL_ABSPATH}/irpoll-config.json ${D}${IR_POLL_STATE_DIR}/irpoll-config.json
    install -m 0644 ${LOCAL_ABSPATH}/irpoll-users.json ${D}${IR_POLL_STATE_DIR}/users.json

    install -d -m 0755 ${D}${sysconfdir}/udev/rules.d/
    install -m 0755 ${WORKDIR}/90-irpoll-usb-device.rules ${D}${sysconfdir}/udev/rules.d/
}

FILES_${PN} += " \
    ${sbindir} \
    ${IR_POLL_STATE_DIR} \
    ${systemd_system_unitdir} \
    ${sysconfdir} \
"
