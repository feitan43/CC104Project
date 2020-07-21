package cc104project;

public class Reservation {
    
     String rname;
     String rtime;
    
    public Reservation(String rname, String rtime){
        this.rname = rname;
        this.rtime = rtime;
    }

    /**
     * @return the rname
     */
    public String getRname() {
        return rname;
    }

    /**
     * @param rname the rname to set
     */
    public void setRname(String rname) {
        this.rname = rname;
    }

    /**
     * @return the rtime
     */
    public String getRtime() {
        return rtime;
    }

    /**
     * @param rtime the rtime to set
     */
    public void setRtime(String rtime) {
        this.rtime = rtime;
    }
    
}
