package concurrent.cash;

import com.beust.ah.A;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Optional;

@ThreadSafe
public class AccountStorage {
    @GuardedBy("this")
    private final HashMap<Integer, Account> accounts = new HashMap<>();

    public synchronized boolean add(Account account) {
        return accounts.putIfAbsent(account.getId(), account) == null;
    }

    public synchronized boolean update(Account account) {
        return accounts.replace(account.getId(), account) != null;
    }

    public synchronized boolean delete(int id) {
        return accounts.remove(id) != null;
    }

    public synchronized Optional<Account> getById(int id) {
        return Optional.ofNullable(accounts.get(id));
    }

    public synchronized boolean transfer(int from, int toId, int amount) {
        Optional<Account> source = getById(from);
        Optional<Account> fromTo = getById(toId);
        if (source.isEmpty() || fromTo.isEmpty() || source.get().getAmount() < amount) {
            throw new IllegalArgumentException("dont have amount");
        }
        source.get().setAmount(source.get().getAmount() - amount);
        fromTo.get().setAmount(fromTo.get().getAmount() + amount);
        return update(source.get()) && update(fromTo.get());
    }
}
