package com.gmail.ourliac.thomas.neighbors.fragments

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gmail.ourliac.thomas.neighbors.NavigationListener
import com.gmail.ourliac.thomas.neighbors.R
import com.gmail.ourliac.thomas.neighbors.data.NeighborRepository
import com.gmail.ourliac.thomas.neighbors.models.Neighbor

class AddNeighborFragment : Fragment() {

    private lateinit var binding: AddNeighborBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as? NavigationListener)?.updateTitle(R.string.add_neighbor)

        binding = AddNeighborBinding.inflate(inflater, container, false)
        with(binding) {
            save_button.isEnabled = false
            nom.addTextChangedListener(this@AddNeighborFragment)
            image.addTextChangedListener(this@AddNeighborFragment)
            adressee.addTextChangedListener(this@AddNeighborFragment)
            tel.addTextChangedListener(this@AddNeighborFragment)
            about.addTextChangedListener(this@AddNeighborFragment)
            website.addTextChangedListener(this@AddNeighborFragment)


            saveButton.setOnClickListener {
                root.hideKeyboard()
                val neighbor = Neighbor(
                    (NeighborRepository.getInstance().getNeighbors().size + 1).toLong(),
                    nom.text.toString(),
                    image.text.toString(),
                    adresse.text.toString(),
                    tel.text.toString(),
                    moi.text.toString(),
                    true,
                    website.text.toString()
                )
                NeighborRepository.getInstance().createNeighbor(neighbor)
                (activity as? NavigationListener)?.showFragment(ListNeighborsFragment())
                Toast.makeText(
                    context,
                    context?.getString(R.string.neighbor_added),
                    Toast.LENGTH_LONG
                ).show()

            }
        }

        return binding.root
    }

    private fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }

    override fun afterTextChanged(s: Editable?) {
        with(binding) {

            if (tel.text.toString().isEmpty()) {
                telLyt.isErrorEnabled = false
            } else {
                if ((tel.text.toString().startsWith("06") || tel.text.toString()
                        .startsWith("07")) && tel.text.toString().length == 10
                ) {
                    telLyt.isErrorEnabled = false
                } else {
                    telLyt.error = context?.getString(R.string.forme_correcte)
                }
            }

            if (adresse.text.toString().isEmpty()) {
                adresseLyt.isErrorEnabled = false
            } else {
                if (isValidEmail(adresse.text.toString())) {
                    adresseLyt.isErrorEnabled = false

                } else {
                    adresseLyt.error = getString(R.string.mail_invalide)
                }
            }

            if (website.text.toString().isEmpty()) {
                websiteLyt.isErrorEnabled = false
            } else {
                if (URLUtil.isValidUrl(website.text.toString())) {
                    websiteLyt.isErrorEnabled = false
                } else {
                    websiteLyt.error = context?.getString(R.string.site_invalide)
                }
            }

            if (image.text.toString().isEmpty()) {
                imageLyt.isErrorEnabled = false
                uploadImageUrlImmediately(R.drawable.ic_baseline_person_add_24.toString())
            } else {
                if (URLUtil.isValidUrl(image.text.toString())) {
                    imageLyt.isErrorEnabled = false
                    uploadImageUrlImmediately(image.text.toString())
                } else {
                    imageLyt.error = context?.getString(R.string.image_invalide)
                    uploadImageUrlImmediately(R.drawable.ic_baseline_person_add_24.toString())
                }
            }

            if (!telLyt.isErrorEnabled && !websiteLyt.isErrorEnabled && !imageLyt.isErrorEnabled && !adresseLyt.isErrorEnabled) {
                saveButton.isEnabled = !(nom.text.toString().isEmpty() ||
                        image.text.toString().isEmpty() ||
                        adresse.text.toString().isEmpty() ||
                        tel.text.toString().isEmpty() ||
                        moi.text!!.isEmpty() ||
                        website.text!!.isEmpty()
                        )
            } else {
                saveButton.isEnabled = false
            }
        }

    }

    private fun uploadImageUrlImmediately(urlImage: String) {
        Glide.with(binding.img.context)
            .load(urlImage)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(R.drawable.ic_baseline_person_outline_24)
            .error(R.drawable.ic_baseline_person_outline_24)
            .skipMemoryCache(false)
            .into(binding.img)
    }

    private fun isValidEmail(email: String): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
