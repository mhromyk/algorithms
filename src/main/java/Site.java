/**
 * The {@code Site} class represents interface for
 * tracking the state of the <b>{@code n}</b> array of sites.
 * Site can have one of the following states:
 *  <li> {@code 0} - is closed site
 *  <li> {@code 1} - is opened site
 *  <li> {@code 2} - is full site
 *
 *
 * */
public class Site {
    private State[] site;
    private final int size;
    private int openedSites;

    public Site(int size) {
        this.site = new State[size];
        this.size = size;
        for (int i=0;i<size;i++){
            site[i] = State.CLOSED;
        }
    }

    public State getState(int i){
        return site[i];
    }

    public void openSite(int i){
        if(site[i]==State.CLOSED){
            openedSites++;
            site[i]=State.OPENED;
        }
    }

    public int getSize() {
        return size;
    }

    public int getOpenedSites(){
        return openedSites;
    }
}
