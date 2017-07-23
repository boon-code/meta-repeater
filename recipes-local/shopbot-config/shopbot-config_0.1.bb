DESCRIPTION = "Setup for shopping bot"
SECTION = "services/setup"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

require conf/local-data.inc
inherit systemd

RDEPENDS_${PN} = "python3-shopbot"

SYSTEMD_SERVICE_${PN} = "shopping-bot.service"

SRC_URI = " \
    file://shopping-bot.service \
    ${LOCALURI}/shopbot-config/shopping-bot.conf \
"

S = "${WORKDIR}"

do_install() {
    install -d -m 0755 ${D}${bindir}/
    install -d -m 0755 ${D}${sysconfdir}/
    install -d -m 0755 ${D}${systemd_system_unitdir}/
    install -d -m 0750 ${D}${sysconfdir}/shopbot/
    install -d -m 0755 ${D}${localstatedir}/lib/shopbot/

    install -m 0644 ${WORKDIR}/shopping-bot.service ${D}${systemd_system_unitdir}/
    install -m 0640 ${WORKDIR}${LOCAL_ABSPATH}/shopbot-config/shopping-bot.conf ${D}${sysconfdir}/shopbot/config
}

FILES_${PN} += " \
    ${bindir} \
    ${sysconfdir}/shopbot \
    ${localstatedir}/lib \
"

CONFFILES_${PN} += " ${sysconfdir}/shopbot/config "
