package ch.qscqlmpa.phonecallnotifier.data.phonenumberformat;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import ch.qscqlmpa.phonecallnotifier.data.database.AppRoomDatabase;
import ch.qscqlmpa.phonecallnotifier.data.database.phonenumberformat.PhoneNumberFormat;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class PhoneNumberFormatRepository {

    private final AppRoomDatabase database;
    private final Scheduler scheduler;

    @Inject
    PhoneNumberFormatRepository(AppRoomDatabase database,
                                @Named("database_scheduler")
                                        Scheduler scheduler) {
        this.database = database;
        this.scheduler = scheduler;
    }

    public Flowable<List<PhoneNumberFormat>> getAllPhoneNumberFormats() {
        return database.phoneNumberFormatRegularDao().getAllPhoneNumberFormats()
                .subscribeOn(scheduler);
    }

    public Single<PhoneNumberFormat> getPhoneNumberFormat(PhoneNumberFormat phoneNumberFormat) {
        return database.phoneNumberFormatRegularDao()
                .getPhoneNumberFormat(phoneNumberFormat.getId())
                .subscribeOn(scheduler);
    }
}
