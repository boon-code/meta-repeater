FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

do_install_append() {
    if [ -e ${D}/${systemd_unitdir}/system/mpd.service ] ; then
        sed -i 's/^RestrictNamespaces=.*$/d' ${D}/${systemd_unitdir}/system/mpd.service
    fi
}
