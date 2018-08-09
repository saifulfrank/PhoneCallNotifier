package ch.qscqlmpa.phonecallnotifier.phonenumberformat.phonenumberformatlist;

import android.support.v7.util.DiffUtil;

import java.util.List;

import ch.qscqlmpa.phonecallnotifier.data.database.phonenumberformat.PhoneNumberFormat;

public class PhoneNumberFormatsDiffCallback extends DiffUtil.Callback {

    private final List<PhoneNumberFormat> oldList;
    private final List<PhoneNumberFormat> newList;

    public PhoneNumberFormatsDiffCallback(List<PhoneNumberFormat> oldList, List<PhoneNumberFormat> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getId() == newList.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        PhoneNumberFormat oldItem = oldList.get(oldItemPosition);
        PhoneNumberFormat newItem = newList.get(newItemPosition);

        return oldItem.getId().equals(newItem.getId())
                && oldItem.getFormat().equals(newItem.getFormat())
                && oldItem.getDescription().equals(newItem.getDescription())
                && oldItem.getIsEnabled().equals(newItem.getIsEnabled());
    }
}
