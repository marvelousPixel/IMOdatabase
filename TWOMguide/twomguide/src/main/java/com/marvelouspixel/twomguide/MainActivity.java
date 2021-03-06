package com.marvelouspixel.twomguide;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    /**
     *  refers to the ListView created in fragment_main.xml
     *
     */
    private static ListView monsterListView;

    /**
     *
     *  number of site
     */

    private static int imaginaryInt;

    public static int uniqueID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.twom_guide);
                break;
            case 2:
                mTitle = getString(R.string.forgotten_cave);
                break;
            case 3:
                mTitle = getString(R.string.silent_altar);
                break;
            case 4:
                mTitle = getString(R.string.impassable_cave);
                break;
            case 5:
                mTitle = getString(R.string.desert_dungeon);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
           args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            /**
             * each fragment returns a different number chronologically.
             */
            imaginaryInt = Integer.valueOf(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));

            if (imaginaryInt == 1){

                TextView text = new TextView(getActivity());
                text.setText("forgotten cave is done");

            }

            /**
             * first instant dungeon : forgotten cave
             */
            CustomAdapter forgottenCaveDung = new CustomAdapter(getActivity());


            forgottenCaveDung.addListItem(R.string.poison_lizard, R.string.twenty5, R.string.common,R.string.forgotten_cave,R.string.poison_lizard_description, R.drawable.ghostsnake);
            forgottenCaveDung.addListItem(R.string.big_eyed_soul, R.string.twenty6, R.string.common,R.string.forgotten_cave,R.string.big_eyed_soul_description, R.drawable.big_eyed_soul);
            forgottenCaveDung.addListItem(R.string.underground_eater,R.string.twenty7, R.string.common,R.string.forgotten_cave,R.string.underground_eater_imp_description,R.drawable.purple_imp);
            forgottenCaveDung.addListItem(R.string.underground_eater,R.string.twenty8,R.string.common,R.string.forgotten_cave,R.string.underground_eater_mummy_description,R.drawable.underground_eater);
            forgottenCaveDung.addListItem(R.string.magic_imp,R.string.twenty9,R.string.common,R.string.forgotten_cave,R.string.magic_imp_description,R.drawable.pink_imp);
            forgottenCaveDung.addListItem(R.string.evil_spirit,R.string.thrity30,R.string.mini_boss,R.string.forgotten_cave,R.string.evil_spirit_description, R.drawable.blue_ghost);
            forgottenCaveDung.addListItem(R.string.walking_death,R.string.thirty1,R.string.mini_boss,R.string.forgotten_cave,R.string.walking_death_description,R.drawable.walking_death);
            forgottenCaveDung.addListItem(R.string.mutanthydra,R.string.thirty2,R.string.boss, R.string.forgotten_cave,R.string.mutanthydra_description,R.drawable.devilang_red);

            // ListView which we introduced in our fragment_main.
            monsterListView = (ListView) rootView.findViewById(R.id.monster_list_view);


            if (imaginaryInt == 3){

            monsterListView.setAdapter(forgottenCaveDung);}

            /**
             *  second instant dungeon silent altair
             */

            CustomAdapter silentAltairDung = new CustomAdapter(getActivity());

            silentAltairDung.addListItem(R.string.altar_cleaner,R.string.unknown,R.string.common,R.string.silent_altar,R.string.altar_cleaner_description,0);
            silentAltairDung.addListItem(R.string.silent_ghost,R.string.unknown,R.string.common,R.string.silent_altar,R.string.silent_ghost_description,0);
            silentAltairDung.addListItem(R.string.rock_golem,R.string.unknown,R.string.common,R.string.silent_altar,R.string.rock_golem_description,R.drawable.brown_mystery);
            silentAltairDung.addListItem(R.string.fluid_form, R.string.unknown, R.string.common, R.string.silent_altar, R.string.fluid_form_description, 0);
            silentAltairDung.addListItem(R.string.mystery,R.string.unknown,R.string.mini_boss,R.string.silent_altar,R.string.mystery_description,R.drawable.mystery);
            silentAltairDung.addListItem(R.string.morphling,R.string.unknown,R.string.mini_boss,R.string.silent_altar,R.string.morphling_description,0);
            silentAltairDung.addListItem(R.string.malterguardian,R.string.unknown,R.string.boss,R.string.silent_altar,R.string.malterguardian_description,R.drawable.turtle);

            if (imaginaryInt == 4 ) {

                monsterListView.setAdapter(silentAltairDung);

            }

            /**
             *  third instant dungeon called impassable cave
             */

            CustomAdapter impassableCaveDung = new CustomAdapter(getActivity());

            impassableCaveDung.addListItem(R.string.cave_spider,R.string.thirty4,R.string.common,R.string.impassable_cave,R.string.cave_spider_description,R.drawable.cave_spider);
            impassableCaveDung.addListItem(R.string.wandering_spider,R.string.thirty5,R.string.common,R.string.impassable_cave,R.string.wandering_spider_description,R.drawable.wandering_spider);
            impassableCaveDung.addListItem(R.string.light_wing,R.string.thirty6,R.string.common,R.string.impassable_cave,R.string.light_wing_description,0);
            impassableCaveDung.addListItem(R.string.hairy,R.string.thirty7,R.string.common,R.string.impassable_cave,R.string.hairy_description,R.drawable.brown_yeti);
            impassableCaveDung.addListItem(R.string.cave_keeper,R.string.thirty8,R.string.common,R.string.impassable_cave,R.string.cave_keeper_description,0);
            impassableCaveDung.addListItem(R.string.darkjuno,R.string.thirty8,R.string.mini_boss,R.string.impassable_cave,R.string.darkjuno_description,R.drawable.juno);
            impassableCaveDung.addListItem(R.string.graysky,R.string.thirty9,R.string.mini_boss,R.string.impassable_cave,R.string.graysky_description,R.drawable.sky);
            impassableCaveDung.addListItem(R.string.whitewadangka,R.string.fourty,R.string.boss,R.string.impassable_cave,R.string.whitewadangka_description,R.drawable.wadangka);


            if (imaginaryInt == 5) {

                monsterListView.setAdapter(impassableCaveDung);
            }

            /**
             * fourth and last dungeon called desert dungeon
             */

            CustomAdapter desertDung = new CustomAdapter(getActivity());

            desertDung.addListItem(R.string.silhouette,R.string.fourty1,R.string.common,R.string.desert_dungeon,R.string.silhouette_description,R.drawable.silhouette);
            desertDung.addListItem(R.string.bandagaman,R.string.fourty2,R.string.common,R.string.desert_dungeon,R.string.bandagaman_description,R.drawable.bandageman);
            desertDung.addListItem(R.string.underground_eater,R.string.fourty3,R.string.common,R.string.desert_dungeon,R.string.underground_eater_sandeater_description,R.drawable.sandeater);
            desertDung.addListItem(R.string.reason_scream,R.string.fourty4,R.string.mini_boss,R.string.desert_dungeon,R.string.reason_scream_description,R.drawable.reason_scream);
            desertDung.addListItem(R.string.gluttony,R.string.fourty5,R.string.mini_boss,R.string.desert_dungeon,R.string.gluttony_description,R.drawable.gluttony);
            desertDung.addListItem(R.string.themama,R.string.fourty6,R.string.boss,R.string.desert_dungeon,R.string.themama_description,R.drawable.medusa);


            if (imaginaryInt == 6) {

                monsterListView.setAdapter(desertDung);
            }

            monsterListView.setOnItemClickListener(new OnListViewClickListener());
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }

        private class OnListViewClickListener implements android.widget.AdapterView.OnItemClickListener {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                monsterListView.setItemChecked(position,true);


                if (position == 0 && imaginaryInt == 3  ) {

                    Intent intent = new Intent(view.getContext(),ListResult.class);
                    intent.putExtra("layout_id",R.layout.dung_poison_lizard);
                    startActivityForResult(intent, 0);


                }
                if (position == 1 && imaginaryInt == 3  ) {
                    uniqueID = 2;
                    Intent intent2 = new Intent(view.getContext(),ListResult.class);
                    startActivityForResult(intent2,0);
                }
            }


        }


    }

}
