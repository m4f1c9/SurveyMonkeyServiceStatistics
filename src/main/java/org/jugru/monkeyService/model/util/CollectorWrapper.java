package org.jugru.monkeyService.model.util;

import java.util.Objects;
import java.util.Set;

public class CollectorWrapper {

    Set<Collector> data;

    public Set<Collector> getData() {
        return data;
    }

    public void setData(Set<Collector> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CollectorWrapper{" + "data=" + data + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.data);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CollectorWrapper other = (CollectorWrapper) obj;
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

}
