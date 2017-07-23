
do_install_append() {
    # Prevents creation of /etc/resolv.conf symlink
    rm ${D}${sysconfdir}/tmpfiles.d/etc.conf
}
