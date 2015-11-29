package uis.tp.grupo1.duelodeleyendas;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class ItemListFragment extends ListFragment {

    private RepoPersonajes repo = new RepoPersonajes();
    private  List<String> personajes = new ArrayList<String>();


    private static final String STATE_ACTIVATED_POSITION = "activated_position";

    private Callbacks mCallbacks = sDummyCallbacks;

    private int mActivatedPosition = ListView.INVALID_POSITION;

    public interface Callbacks {
        public void onItemSelected(String id);
    }

    private static Callbacks sDummyCallbacks = new Callbacks() {
        @Override
        public void onItemSelected(String id) {
        }
    };

    public ItemListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        obtenerPersonajes();
    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null
                && savedInstanceState.containsKey(STATE_ACTIVATED_POSITION)) {
            setActivatedPosition(savedInstanceState.getInt(STATE_ACTIVATED_POSITION));
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof Callbacks)) {
            throw new IllegalStateException("Activity must implement fragment's callbacks.");
        }

        mCallbacks = (Callbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = sDummyCallbacks;
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);
        mCallbacks.onItemSelected(personajes.get(position));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mActivatedPosition != ListView.INVALID_POSITION) {
            outState.putInt(STATE_ACTIVATED_POSITION, mActivatedPosition);
        }
    }


/*    private List<String> obtenerPersonajes() {
        PersonajesServices pjServices = createPeliculasServices();
        pjServices.getPersonajesNombres(new Callback<List<String>>() {
            @Override
            public void success(List<String> pjs, Response response) {
                personajes = pjs;
            }

            @Override
            public void failure(RetrofitError error) {

            }

        });
        return personajes;
    }
*/

    private void obtenerPersonajes() {
        PersonajesServices pjServices = createPeliculasServices();
        pjServices.getPersonajesNombres(new Callback<List<String>>() {
            @Override
            public void success(List<String> pjs, Response response) {
                personajes = pjs;
                agregarPersonajes(pjs);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void agregarPersonajes(List<String> pjs) {
        setListAdapter(new PersonajesAdapter(getActivity(), pjs));
    }


    public void setActivateOnItemClick(boolean activateOnItemClick) {
        getListView().setChoiceMode(activateOnItemClick
                ? ListView.CHOICE_MODE_SINGLE
                : ListView.CHOICE_MODE_NONE);
    }

    private void setActivatedPosition(int position) {
        if (position == ListView.INVALID_POSITION) {
            getListView().setItemChecked(mActivatedPosition, false);
        } else {
            getListView().setItemChecked(position, true);
        }

        mActivatedPosition = position;
    }

    private PersonajesServices createPeliculasServices(){
        String SERVER_IP = "127.0.0.1";
        String SERVER_IP_GENY= "127.0.0.1";
        String API_URL = "http://192.168.1.37:9000";
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API_URL).build();
        PersonajesServices personajesServicess = restAdapter.create(PersonajesServices.class);
        return personajesServicess;
    }
}
