package com.jerich06g.pokemon_gen6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PokemonBottomSheet : BottomSheetDialogFragment() {
    companion object {
        private const val ARG_NAME = "name"
        private const val ARG_TYPE = "type"
        private const val ARG_EVO = "evoLevel"
        private const val ARG_LOCATION = "location"

        fun newInstance(pokemon: Pokemon): PokemonBottomSheet {
            val sheet = PokemonBottomSheet()
            sheet.arguments = Bundle().apply {
                putString(ARG_NAME, pokemon.name)
                putString(ARG_TYPE, pokemon.type)
                putString(ARG_EVO, pokemon.evoLevel)
                putString(ARG_LOCATION, pokemon.location)
            }
            return sheet
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate bottom sheet layout
        return inflater.inflate(R.layout.fragment_pokemon_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Pull Pokemon data back out of arguments bundle
        val name = arguments?.getString(ARG_NAME) ?: ""
        val type = arguments?.getString(ARG_TYPE) ?: ""
        val evo = arguments?.getString(ARG_EVO) ?: ""
        val location = arguments?.getString(ARG_LOCATION) ?: ""

        // Populate views
        view.findViewById<TextView>(R.id.sheetName).text = name
        view.findViewById<TextView>(R.id.sheetType).text = "Type: $type"
        view.findViewById<TextView>(R.id.sheetEvo).text = "Evolution: $evo"
        view.findViewById<TextView>(R.id.sheetLocation).text = "Where to find: $location"
    }
}