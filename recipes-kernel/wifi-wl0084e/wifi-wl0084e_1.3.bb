SUMMARY = "WIFI driver for code for WL 0084E"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=801f80980d171dd6425610833a22dbe6"

inherit module

SRC_URI = "file://rtl8188EUS_linux_v4.3.0.8_13968.20150417.tar.gz \
           file://COPYING \
           file://8188eu.conf \
           file://0001-Fix-Kernel-source-path-for-Yocto.patch \
           file://0002-Fix-compile-errors.patch \
           file://0003-Add-modules_install-rule.patch \
           file://0004-Add-build-rule-for-Raspberry-PI.patch \
           file://0005-Fix-cfg80211-interface-for-Kernel-4.1.patch \
           file://0006-Adapt-to-seq_printf-prototype-changes.patch \
           file://0007-Silence-warnings-about-wrong-indentation.patch \
           file://0008-Rename-file_path-variable.patch \
           file://0009-Fix-call-to-cfg80211_disconnected.patch \
           file://0010-Adapt-to-parameter-changes-in-cfg80211.patch \
"

S = "${WORKDIR}/rtl8188EUS_linux_v4.3.0.8_13968.20150417"

do_configure_prepend() {
    cp "${WORKDIR}/COPYING" "${S}/COPYING"
}

do_install_prepend() {
    install -d ${D}${sysconfdir}/modprobe.d
    install -m 0644 ${WORKDIR}/8188eu.conf ${D}${sysconfdir}/modprobe.d
}

FILES_${PN} += "${sysconfdir}/modprobe.d/8188eu.conf"
