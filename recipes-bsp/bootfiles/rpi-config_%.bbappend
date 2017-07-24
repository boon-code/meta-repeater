
do_deploy_append() {
    cat >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt <<EOF

# Enable audio:
hdmi_ignore_edid_audio=1
dtparam=audio=on

#Reduce boot-delay
boot_delay=0
EOF
}
