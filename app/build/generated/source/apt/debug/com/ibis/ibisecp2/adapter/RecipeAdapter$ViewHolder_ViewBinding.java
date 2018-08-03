// Generated code from Butter Knife. Do not modify!
package com.ibis.ibisecp2.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ibis.ibisecp2.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RecipeAdapter$ViewHolder_ViewBinding implements Unbinder {
  private RecipeAdapter.ViewHolder target;

  @UiThread
  public RecipeAdapter$ViewHolder_ViewBinding(RecipeAdapter.ViewHolder target, View source) {
    this.target = target;

    target.textViewTitleRecept = Utils.findRequiredViewAsType(source, R.id.textViewTitleRecept, "field 'textViewTitleRecept'", TextView.class);
    target.textViewDateRecipe = Utils.findRequiredViewAsType(source, R.id.textViewDateRecipe, "field 'textViewDateRecipe'", TextView.class);
    target.textViewRecipeDosage = Utils.findRequiredViewAsType(source, R.id.textViewRecipeDosage, "field 'textViewRecipeDosage'", TextView.class);
    target.textViewQuantity = Utils.findRequiredViewAsType(source, R.id.textViewQuantity, "field 'textViewQuantity'", TextView.class);
    target.textViewRecipeDoc = Utils.findRequiredViewAsType(source, R.id.textViewRecipeDoc, "field 'textViewRecipeDoc'", TextView.class);
    target.textViewRecipeSeries = Utils.findRequiredViewAsType(source, R.id.textViewRecipeSeries, "field 'textViewRecipeSeries'", TextView.class);
    target.textViewRecipeNumber = Utils.findRequiredViewAsType(source, R.id.textViewRecipeNumber, "field 'textViewRecipeNumber'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RecipeAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textViewTitleRecept = null;
    target.textViewDateRecipe = null;
    target.textViewRecipeDosage = null;
    target.textViewQuantity = null;
    target.textViewRecipeDoc = null;
    target.textViewRecipeSeries = null;
    target.textViewRecipeNumber = null;
  }
}
