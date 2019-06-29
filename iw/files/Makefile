ALL = iw

# Add any other object files to this list below

OBJS = ap.o bitrate.o bloom.o coalesce.o connect.o cqm.o event.o ftm.o genl.o hwsim.o ibss.o info.o interface.o iw.o link.o measurements.o mesh.o mgmt.o mpath.o mpp.o nan.o ocb.o offch.o p2p.o phy.o ps.o reason.o reg.o roc.o scan.o sections.o sha256.o station.o status.o survey.o util.o vendor.o wowlan.o version.o

LDLIBS += -L${MYLIBDIR} -lnl-3 -lnl-genl-3 -lnl-nf-3 -lnl-route-3

all: $(ALL)

version.c: version.sh
	./version.sh $@

$(ALL): $(OBJS)
	$(CC) $(LDFLAGS) -o $@ $(OBJS) $(LDLIBS)

clean:
	-rm -f $(ALL) *.elf *.gdb *.o

